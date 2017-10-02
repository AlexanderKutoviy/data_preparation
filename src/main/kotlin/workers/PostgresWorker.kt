package workers

import dto.CompanyDto
import org.jetbrains.exposed.sql.Table
import java.sql.DriverManager
import java.sql.Connection


class PostgresWorker {

    fun insert(companies: List<CompanyDto>) {
        try {
            Class.forName("org.postgresql.Driver")
            val c: Connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lab1",
                    "postgres", "123")
            c.autoCommit = false
            println("Opened database successfully")

            var i = 0
            companies.forEach {
                println(it)
                val stmt = c.createStatement()
                val sql = "INSERT INTO companies (id, company_name, job_title, longitude, latitude) " +
                        "VALUES (${++i},'${it.company_name}', '${it.job_title}', ${it.longitude}, ${it.latitude});"
                stmt.executeUpdate(sql)
                stmt.close()
            }
            c.commit()
            c.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}