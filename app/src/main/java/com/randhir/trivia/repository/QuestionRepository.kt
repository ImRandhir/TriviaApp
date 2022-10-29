package com.randhir.trivia.repository

import android.util.Log
import com.randhir.trivia.data.DataOrException
import com.randhir.trivia.model.QuestionItem
import com.randhir.trivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {

    private val DataOrException = DataOrException<ArrayList<QuestionItem>,
                                  Boolean,
                                  Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, java.lang.Exception>{
        try {

            DataOrException.loading = true // now we can tell the user that data is loading by using some progress bar in UI
            DataOrException.data = api.getAllQuestions()

            if(DataOrException.data.toString().isNotEmpty()) DataOrException.loading = false

        }catch(exception: java.lang.Exception){

            DataOrException.e = exception
            Log.d("Exception", "getAllQuestions: ${DataOrException.e!!.localizedMessage}")

        }

        return DataOrException

    }

}