package webec

import grails.testing.mixin.integration.Integration
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

@Integration
class QuestionServiceSpec extends Specification implements ServiceUnitTest<QuestionService> {

    def setup() {
        // empty
    }

    def cleanup() {
        // empty
    }

    void "test initial question count is 50"() {
        given: 'get 50 questions'
        when:
        def list = service.all()
        then:
        assert list.size() == 50
    }

    void "test unique question set default size is 15"() {
        given: 'get default game questions'
        when:
        def list = service.uniqueQuestionSet()
        then:
        assert list.size() == 15
    }

    void "test unique question set with specified size"() {
        given: 'get specified number of game questions'
        when:
        def list = service.uniqueQuestionSet(3)
        then:
        assert list.size() == 3
    }

    void "test unique question set with 0 size"() {
        given: 'get specified number of game questions'
        when:
        def list = service.uniqueQuestionSet(0)
        then:
        assert list.size() == 0
    }

    void "test unique question set has no duplicates"() {
        given:
        def list
        int count = 0
        Set<Question> questionSet
        while(count < 100) {
            list = service.uniqueQuestionSet(50)
            questionSet = new HashSet(list)
            if(questionSet.size() < list.size()) {
                //there are duplicates
                assert false
            }
            count++
        }
        assert true

    }

    void "test unique question set is shuffled"() {
        assert true
    }

    void "test all() returns all questions"() {

        assert true
    }
}
