package workers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dto.CompanyDto
import org.json.XML
import java.io.File

class XmlWorker {

    @Suppress("PrivatePropertyName")
    private val FILE_NAME = "dataset.xml"

    private var gson = Gson()

    fun performParsing() {
        val jsonString = XML.toJSONObject(File(FILE_NAME).readText()).getJSONObject("dataset").getString("record")
        println(jsonString)
        val companiesList = gson.fromJson<ArrayList<CompanyDto>>(jsonString,
                object : TypeToken<ArrayList<CompanyDto>>() {}.type)
                as ArrayList<CompanyDto>
        println("XmlWorker COMPANY : $companiesList")
    }
}