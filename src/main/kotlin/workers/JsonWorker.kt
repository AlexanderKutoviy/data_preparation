package workers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dto.CompanyDto
import java.io.File

class JsonWorker {

    @Suppress("PrivatePropertyName")
    private val FILE_NAME = "dataset.json"

    private var gson = Gson()

    fun performParsing() {
        val companiesList = gson.fromJson<ArrayList<CompanyDto>>(File(FILE_NAME).readText(),
                object : TypeToken<ArrayList<CompanyDto>>() {}.type)
                as ArrayList<CompanyDto>
        println("JsonWorkerCOMPANY : $companiesList")
    }
}