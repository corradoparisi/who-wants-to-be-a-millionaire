package webec

import groovy.json.JsonSlurper
import org.apache.commons.lang.StringEscapeUtils

class PlayController {
    def playService
    def questionService
    String hello = "HELLOOO"
    int counter = 0
    Game game;

    def index() {
//        String getResult = new URL('https://opentdb.com/api.php?amount=50&category=9&difficulty=easy&type=multiple').text
//        println(getResult)
//
//        def testEscape = "&lt;Fran&ccedil;ais&gt;"
//        def testEscape2 = '{\"response_code\":0,\"results\":[{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Virgin Trains, Virgin Atlantic and Virgin Racing, are all companies owned by which famous entrepreneur?   \",\"correct_answer\":\"Richard Branson\",\"incorrect_answers\":[\"Alan Sugar\",\"Donald Trump\",\"Bill Gates\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Where is the train station &quot;Llanfair&shy;pwllgwyngyll&shy;gogery&shy;chwyrn&shy;drobwll&shy;llan&shy;tysilio&shy;gogo&shy;goch&quot'
//        def html2 = StringEscapeUtils.unescapeHtml(testEscape2)
//        println("before " + testEscape2)
//        println("after " + html2)


//        String jsonQuestions = StringEscapeUtils.unescapeHtml('{\"response_code\":0,\"results\":[{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Virgin Trains, Virgin Atlantic and Virgin Racing, are all companies owned by which famous entrepreneur?   \",\"correct_answer\":\"Richard Branson\",\"incorrect_answers\":[\"Alan Sugar\",\"Donald Trump\",\"Bill Gates\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Where is the train station &quot;Llanfair&shy;pwllgwyngyll&shy;gogery&shy;chwyrn&shy;drobwll&shy;llan&shy;tysilio&shy;gogo&shy;goch&quot;?\",\"correct_answer\":\"Wales\",\"incorrect_answers\":[\"Moldova\",\"Czech Republic\",\"Denmark\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the most common surname Wales?\",\"correct_answer\":\"Jones\",\"incorrect_answers\":[\"Williams\",\"Davies\",\"Evans\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What was the name of the WWF professional wrestling tag team made up of the wrestlers Ax and Smash?\",\"correct_answer\":\"Demolition\",\"incorrect_answers\":[\"The Dream Team\",\"The Bushwhackers\",\"The British Bulldogs\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"In the video-game franchise Kingdom Hearts, the main protagonist, carries a weapon with what shape?\",\"correct_answer\":\"Key\",\"incorrect_answers\":[\"Sword\",\"Pen\",\"Cellphone\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which best selling toy of 1983 caused hysteria, resulting in riots breaking out in stores?\",\"correct_answer\":\"Cabbage Patch Kids\",\"incorrect_answers\":[\"Transformers\",\"Care Bears\",\"Rubik&rsquo;s Cube\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What does a funambulist walk on?\",\"correct_answer\":\"A Tight Rope\",\"incorrect_answers\":[\"Broken Glass\",\"Balls\",\"The Moon\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Area 51 is located in which US state?\",\"correct_answer\":\"Nevada\",\"incorrect_answers\":[\"Arizona\",\"New Mexico\",\"Utah\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"How would one say goodbye in Spanish?\",\"correct_answer\":\"Adi&oacute;s\",\"incorrect_answers\":[\" Hola\",\"Au Revoir\",\"Salir\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the largest organ of the human body?\",\"correct_answer\":\"Skin\",\"incorrect_answers\":[\"Heart\",\"large Intestine\",\"Liver\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which sign of the zodiac is represented by the Crab?\",\"correct_answer\":\"Cancer\",\"incorrect_answers\":[\"Libra\",\"Virgo\",\"Sagittarius\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"On a dartboard, what number is directly opposite No. 1?\",\"correct_answer\":\"19\",\"incorrect_answers\":[\"20\",\"12\",\"15\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What word represents the letter &#039;T&#039; in the NATO phonetic alphabet?\",\"correct_answer\":\"Tango\",\"incorrect_answers\":[\"Target\",\"Taxi\",\"Turkey\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What alcoholic drink is made from molasses?\",\"correct_answer\":\"Rum\",\"incorrect_answers\":[\"Gin\",\"Vodka\",\"Whisky\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which American president appears on a one dollar bill?\",\"correct_answer\":\"George Washington\",\"incorrect_answers\":[\"Thomas Jefferson\",\"Abraham Lincoln\",\"Benjamin Franklin\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is &quot;dabbing&quot;?\",\"correct_answer\":\"A dance\",\"incorrect_answers\":[\"A medical procedure\",\"A sport\",\"A language\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the shape of the toy invented by Hungarian professor Ern\\u0151 Rubik?\",\"correct_answer\":\"Cube\",\"incorrect_answers\":[\"Sphere\",\"Cylinder\",\"Pyramid\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the name of the Jewish New Year?\",\"correct_answer\":\"Rosh Hashanah\",\"incorrect_answers\":[\"Elul\",\"New Year\",\"Succoss\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is on display in the Madame Tussaud&#039;s museum in London?\",\"correct_answer\":\"Wax sculptures\",\"incorrect_answers\":[\"Designer clothing\",\"Unreleased film reels\",\"Vintage cars\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which of these colours is NOT featured in the logo for Google?\",\"correct_answer\":\"Pink\",\"incorrect_answers\":[\"Yellow\",\"Blue\",\"Green\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the Spanish word for &quot;donkey&quot;?\",\"correct_answer\":\"Burro\",\"incorrect_answers\":[\"Caballo\",\"Toro\",\"Perro\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Five dollars is worth how many nickles?\",\"correct_answer\":\"100\",\"incorrect_answers\":[\"50\",\"25\",\"69\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What do the letters in the GMT time zone stand for?\",\"correct_answer\":\"Greenwich Mean Time\",\"incorrect_answers\":[\"Global Meridian Time\",\"General Median Time\",\"Glasgow Man Time\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which one of these is not a typical European sword design?\",\"correct_answer\":\"Scimitar\",\"incorrect_answers\":[\"Falchion\",\"Ulfberht\",\"Flamberge\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which American-owned brewery led the country in sales by volume in 2015?\",\"correct_answer\":\"D. G. Yuengling and Son, Inc\",\"incorrect_answers\":[\"Anheuser Busch\",\"Boston Beer Company\",\"Miller Coors\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"According to Sherlock Holmes, &quot;If you eliminate the impossible, whatever remains, however improbable, must be the...&quot;\",\"correct_answer\":\"Truth\",\"incorrect_answers\":[\"Answer\",\"Cause\",\"Source\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the name of Poland in Polish?\",\"correct_answer\":\"Polska\",\"incorrect_answers\":[\"Pupcia\",\"Polszka\",\"P&oacute;land\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"The New York Times slogan is, &ldquo;All the News That&rsquo;s Fit to&hellip;&rdquo;\",\"correct_answer\":\"Print\",\"incorrect_answers\":[\"Digest\",\"Look\",\"Read\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What do the letters of the fast food chain KFC stand for?\",\"correct_answer\":\"Kentucky Fried Chicken\",\"incorrect_answers\":[\"Kentucky Fresh Cheese\",\"Kibbled Freaky Cow\",\"Kiwi Food Cut\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"How tall is the Burj Khalifa?\",\"correct_answer\":\"2,722 ft\",\"incorrect_answers\":[\"2,717 ft\",\"2,546 ft\",\"3,024 ft\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which of the following card games revolves around numbers and basic math?\",\"correct_answer\":\"Uno\",\"incorrect_answers\":[\"Go Fish\",\"Twister\",\"Munchkin\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What machine element is located in the center of fidget spinners?\",\"correct_answer\":\"Bearings\",\"incorrect_answers\":[\"Axles\",\"Gears\",\"Belts\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which sign of the zodiac comes between Virgo and Scorpio?\",\"correct_answer\":\"Libra\",\"incorrect_answers\":[\"Gemini\",\"Taurus\",\"Capricorn\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which of the following presidents is not on Mount Rushmore?\",\"correct_answer\":\"John F. Kennedy\",\"incorrect_answers\":[\"Theodore Roosevelt\",\"Abraham Lincoln\",\"Thomas Jefferson\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is Tasmania?\",\"correct_answer\":\"An Australian State\",\"incorrect_answers\":[\"A flavor of Ben and Jerry&#039;s ice-cream\",\"A Psychological Disorder\",\"The Name of a Warner Brothers Cartoon Character\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which candy is NOT made by Mars?\",\"correct_answer\":\"Almond Joy\",\"incorrect_answers\":[\"M&amp;M&#039;s\",\"Twix\",\"Snickers\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"In which fast food chain can you order a Jamocha Shake?\",\"correct_answer\":\"Arby&#039;s\",\"incorrect_answers\":[\"McDonald&#039;s\",\"Burger King\",\"Wendy&#039;s\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which of the following is the IATA code for Manchester Airport?\",\"correct_answer\":\"MAN\",\"incorrect_answers\":[\"EGLL\",\"LHR\",\"EGCC\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the Zodiac symbol for Gemini?\",\"correct_answer\":\"Twins\",\"incorrect_answers\":[\"Fish\",\"Scales\",\"Maiden\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What zodiac sign is represented by a pair of scales?\",\"correct_answer\":\"Libra\",\"incorrect_answers\":[\"Aries\",\"Capricorn\",\"Sagittarius\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What nuts are used in the production of marzipan?\",\"correct_answer\":\"Almonds\",\"incorrect_answers\":[\"Peanuts\",\"Walnuts\",\"Pistachios\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"The likeness of which president is featured on the rare \$2 bill of USA currency?\",\"correct_answer\":\"Thomas Jefferson\",\"incorrect_answers\":[\"Martin Van Buren\",\"Ulysses Grant\",\"John Quincy Adams\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is Cynophobia the fear of?\",\"correct_answer\":\"Dogs\",\"incorrect_answers\":[\"Birds\",\"Flying\",\"Germs\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"According to the nursery rhyme, what fruit did Little Jack Horner pull out of his Christmas pie?\",\"correct_answer\":\"Plum\",\"incorrect_answers\":[\"Apple\",\"Peach\",\"Pear\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Terry Gilliam was an animator that worked with which British comedy group?\",\"correct_answer\":\"Monty Python\",\"incorrect_answers\":[\"The Goodies&lrm;\",\"The League of Gentlemen&lrm;\",\"The Penny Dreadfuls\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"When someone is inexperienced they are said to be what color?\",\"correct_answer\":\"Green\",\"incorrect_answers\":[\"Red\",\"Blue\",\"Yellow\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"When one is &quot;envious&quot;, they are said to be what color?\",\"correct_answer\":\"Green\",\"incorrect_answers\":[\"Red\",\"Blue\",\"Yellow\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"When someone is cowardly, they are said to have what color belly?\",\"correct_answer\":\"Yellow\",\"incorrect_answers\":[\"Green\",\"Red\",\"Blue\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Earth is located in which galaxy?\",\"correct_answer\":\"The Milky Way Galaxy\",\"incorrect_answers\":[\"The Mars Galaxy\",\"The Galaxy Note\",\"The Black Hole\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What are Panama hats made out of?\",\"correct_answer\":\"Straw\",\"incorrect_answers\":[\"Silk\",\"Hemp\",\"Flax\"]}]}\n')
//        try {
//            // Question API from opentdb
//            jsonQuestions = StringEscapeUtils.unescapeHtml(new URL('https://opentdb.com/api.php?amount=50&category=9&difficulty=easy&type=multiple').text)
//        } catch (Exception ignored) {
//            // ignore website unavailable
//        }
//
//        def slurper = new JsonSlurper()
//        slurper.parseText(jsonQuestions).results.each {
//            def question = new Question(questionText: it.question, correct: it.correct_answer, second: it.incorrect_answers.get(0), third: it.incorrect_answers.get(1), fourth: it.incorrect_answers.get(2))
//            println(question)
//            save(question)
//        }

        String answer = params.get("answer")
        if (answer == null || answer.isEmpty()) {
            game = new Game(current: 0, questions: questionService.uniqueQuestionSet(3), isFinished: false);
        } else {
            def correct = game.questions[game.current].correct
            if (answer == correct) {
                game.current++
                if (game.current == game.questions.size()) {
                    render(view: 'won')
                }
            } else {
                render(view: 'lost')
            }
        }

        [game: game]
    }

    def moderator() {
        [questions: questionService.uniqueQuestionSet()]
    }


}

class Game {
    int current;
    List<Question> questions;
    boolean isFinished;
}
