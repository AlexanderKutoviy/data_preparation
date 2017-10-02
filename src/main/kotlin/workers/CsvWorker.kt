package workers

import com.google.gson.Gson
import dto.CompanyDto
import org.apache.commons.csv.CSVFormat
import java.io.FileReader


class CsvWorker {

    @Suppress("PrivatePropertyName")
    private val FILE_NAME = "dataset.csv"

    private var gson = Gson()
    private var companiesList: ArrayList<CompanyDto> = ArrayList()

    fun performParsing() {
        val input = FileReader(FILE_NAME)
        val records = CSVFormat.EXCEL.parse(input)
        for (record in records) {
            companiesList.add(CompanyDto(record[0],
                    record[1],
                    record[2].toDouble(),
                    record[3].toDouble())
            )
        }
        println("CSV : $companiesList")
    }
}