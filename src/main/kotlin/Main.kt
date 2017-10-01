import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class Main {
    companion object {
        private var gson = Gson()

        @JvmStatic
        fun main(args: Array<String>) {
            println("HELLO")
            val companiesList = gson.fromJson<ArrayList<CompanyDto>>(File("dataset.json").readText(),
                    object : TypeToken<ArrayList<CompanyDto>>() {}.type)
                    as ArrayList<CompanyDto>

            companiesList.forEach { println("COMPANY : $it") }
        }
    }
}