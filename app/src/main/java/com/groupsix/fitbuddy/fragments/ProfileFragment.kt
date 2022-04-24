package com.groupsix.fitbuddy.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.groupsix.fitbuddy.MainActivity
import com.groupsix.fitbuddy.PostAdapter
import com.groupsix.fitbuddy.R
import com.parse.*
import java.io.File

// TODO: Rename parameter arguments, choose names that match

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment(), AdapterView.OnItemSelectedListener {

    lateinit var gender : String
    lateinit var height_feet : String
    lateinit var height_feet_number : Number

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //This is where we set up our views and click listeners

        val gender_spinner: Spinner = view.findViewById(R.id.gender_spinner)
        val height_feet_spinner: Spinner = view.findViewById(R.id.height_feet_spinner)
        val height_inches_spinner: Spinner = view.findViewById(R.id.height_inches_spinner)
        val fitness_goals_spinner: Spinner = view.findViewById(R.id.fitness_goal_spinner)

        gender_spinner.setEnabled(false);

        view.findViewById<Button>(R.id.btn_edit).setOnClickListener {

            //Enable spinner dropdowns
            gender_spinner.setEnabled(true)
            height_feet_spinner.setEnabled(true)
            height_inches_spinner.setEnabled(true)
            fitness_goals_spinner.setEnabled(true)

            // gender spinner Array
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.gender_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                gender_spinner.adapter = adapter
            }

            // height feet spinner array
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.height_feet_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                height_feet_spinner.adapter = adapter
            }

            // height inches spinner array

            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.height_inches_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                height_inches_spinner.adapter = adapter
            }


            // fitness goals spinner array

            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.fitness_goals_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                fitness_goals_spinner.adapter = adapter
            }
            // Create an ArrayAdapter using the string array and a default spinner layout
            gender_spinner.onItemSelectedListener = this
            height_feet_spinner.onItemSelectedListener = this
            height_inches_spinner.onItemSelectedListener = this
            fitness_goals_spinner.onItemSelectedListener = this

        }

        view.findViewById<Button>(R.id.btn_save).setOnClickListener {
            gender_spinner.setEnabled(false);
            height_feet_spinner.setEnabled(false);
            height_inches_spinner.setEnabled(false);
            fitness_goals_spinner.setEnabled(false);
            val user = ParseUser.getCurrentUser()
            //val height = view.findViewById<Spinner>(R.id.).text.toString()
            submitHealthData(gender, user)
            // submit HealthData
        }

    }

    fun submitHealthData(gender: String, user: ParseUser) {
        //Create the post inject
        val healthData = HealthData2()
        if(gender == "Male"){
            healthData.setMale(true)
            healthData.setFemale(false)
            Log.i("ProfileFragment: ", gender)
        }
        else{
            healthData.setMale(false)
            healthData.setFemale(true)
            Log.i("ProfileFragment: ", gender)
        }

        healthData.setUser(user)
        healthData.setHeightFeet(height_feet_number)

        healthData.saveInBackground { exception ->
            if (exception != null) {
                //something has went wrong
                Log.e(MainActivity.TAG, "Error while saving health data")
                exception.printStackTrace()
                //TODO: Show a toast to tell user something has went wrong with saving post
                Toast.makeText(requireContext(), "Health data save Error", Toast.LENGTH_SHORT).show()
            } else {
                Log.i(MainActivity.TAG, "Successfully saved health data")
                //TODO: Resetting the EditText field to be empty
                //TODO: Reset the ImageView to empty
                Toast.makeText(requireContext(), "health data Successful", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        if(parent?.id == R.id.gender_spinner){
            gender = parent?.getItemAtPosition(pos) as String
        }
        if(parent?.id == R.id.height_feet_spinner){
            height_feet = parent?.getItemAtPosition(pos) as String
            height_feet_number = Integer.parseInt(height_feet)
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
        gender = "Male"
    }



}