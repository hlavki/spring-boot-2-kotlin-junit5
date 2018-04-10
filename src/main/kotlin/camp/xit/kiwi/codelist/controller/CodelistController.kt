package camp.xit.kiwi.codelist.controller

import camp.xit.kiwi.codelist.model.CodelistEntry
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CodelistController {

    @GetMapping("/api/v1/codelist/{code}")
    fun getCodelist(@PathVariable code: String) =
            listOf(CodelistEntry("PICA"), CodelistEntry("KOKOT"))

}