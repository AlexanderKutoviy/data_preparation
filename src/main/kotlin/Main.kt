import workers.CsvWorker
import workers.JsonWorker
import workers.XmlWorker

class Main {
    companion object {

        private val jsonWorker: JsonWorker = JsonWorker()
        private val xmlWorker: XmlWorker = XmlWorker()
        private val csvWorker: CsvWorker = CsvWorker()

        @JvmStatic
        fun main(args: Array<String>) {
            jsonWorker.performParsing()
            xmlWorker.performParsing()
            csvWorker.performParsing()
        }
    }
}