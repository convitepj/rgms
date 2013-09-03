import pages.LoginPage
import pages.PublicationsPage
import pages.BibtexImportPage
import rgms.publication.*
import steps.TestDataBibTexFile

import static cucumber.api.groovy.EN.*
import steps.TestDataAndOperations

def LogInToPublication(){
    to LoginPage
    at LoginPage
    page.fillLoginData("admin", "adminadmin")
    at PublicationsPage
}
//You can implement missing steps with the snippets below:
Given(~'^I am on Import Bibtex File Menu$') {->
    LogInToPublication()
    page.select("Import Bibtex File")
    at BibtexImportPage
}

When(~'^I click "([^"]*)"$') { String arg1 ->
    System.println(arg1)
    at BibtexImportPage
    page.selectButton(arg1)
}

When(~'^I select a bibtex file and I click "([^"]*)"$') { String arg1 ->
    System.println(arg1)
    BibtexFile bibtexFile = TestDataBibTexFile.openBibTexFile("sample.bibtex")
    page.selectButton(arg1)

}

Then(~'^all corresponding publications are created$') {->
    BibtexFile bibtexFile = TestDataBibTexFile.openBibTexFile("sample.bibtex")
    assert bibtexFile.getPublications().size() == 3
}

Then(~'^all of then are stored$') {->
}

When(~'^I select a bibtex file unformatted and I click "([^"]*)"$') { String arg1 -> 6
}

//@Test(expected=RuntimeException.class)
Then(~'^the system output the message error "([^"]*)"$') { String arg1 ->
    BibtexFile bibtexFile = TestDataBibTexFile.openBibTexFile("sample.bibtex")
}

Then(~'^none publication is stored$') {->
    assert Publication.getAll().size() == 0
}

When(~'^I select a bibtex file with one Dissertation and two Thesis and I click "([^"]*)"$') { String arg1 ->
}

Then(~'^is created one Dissertation publication$') {->
    BibtexFile bibtexFile = TestDataBibTexFile.openBibTexFile("sample.bibtex")
    assert bibtexFile.getPublications(Conferencia.class).isEmpty()
    assert bibtexFile.getPublications(Dissertacao.class).size() == 1
}

Then(~'^is created two Thesis publications$') {->
    BibtexFile bibtexFile = TestDataBibTexFile.openBibTexFile("sample.bibtex")
    assert bibtexFile.getPublications(TechnicalReport.class).isEmpty()
    assert bibtexFile.getPublications(Tese.class).size() == 2
}

Then(~'^one Dissertation is stored and two Thesis is stored$') {->
}
