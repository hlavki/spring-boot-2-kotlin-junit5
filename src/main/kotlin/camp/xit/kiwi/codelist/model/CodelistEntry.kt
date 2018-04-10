package camp.xit.kiwi.codelist.model

import java.time.LocalDate

data class CodelistEntry(
        val code: String,
        val name: String? = null,
        val order: Int? = null,
        val validFrom: LocalDate? = null,
        val validTo: LocalDate? = null) : Comparable<CodelistEntry> {


    override fun compareTo(other: CodelistEntry) =
            compareValuesBy(this, other, CodelistEntry::order, CodelistEntry::code)
}
