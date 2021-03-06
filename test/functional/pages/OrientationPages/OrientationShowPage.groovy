package pages.OrientationPages

import geb.Page
import pages.GetPageTitle

class OrientationShowPage extends Page {
    static url = "orientation/show/1"

    static at = {
        //title ==~ /Ver orientation/

        GetPageTitle gp = new GetPageTitle()
        def currentOrientation = gp.msg("default.orientation.label")
        def currentTitle = gp.msg("default.show.label", [currentOrientation])

        title ==~ currentTitle
    }

    static content = {
    }

    def select() {
        $("form").find('a', class: 'edit').click()
    }
//#if ($Twitter)
    def clickOnTwitteIt(String login, pw) {
        $("#button_twitter").click()
        //$("#password").text = login
        //$("#username_or_email").text = pw
        //$("input", type:"submit", class:"button selected submit", value:"Entrar e Tweetar").click()
        //<input type="submit" class="button selected submit" value="Entrar e Tweetar">
    }
//#end
//#if ($Facebook)
    def clickOnFacebookIt(String login, pw, message) {
        $("#share_facebook").click()
        //$("#password").text = login
        //$("#username_or_email").text = pw
        //$("input", type:"submit", class:"button selected submit", value:"Entrar e Tweetar").click()
        //<input type="submit" class="button selected submit" value="Entrar e Tweetar">
    }
//#end
}
