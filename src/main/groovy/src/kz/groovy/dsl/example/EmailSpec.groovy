package src.kz.groovy.dsl.example

import groovy.json.JsonBuilder
import groovy.json.JsonOutput

class BodySpec {

    private String body

    void p(String bodyText) {
        this.body = bodyText
    }

    @Override
    String toString() {
        JsonBuilder builder = new JsonBuilder()
        builder.body {
            text this.body
        }
        return builder.toString()
    }
}

class EmailSpec {

    private String from
    private String[] to
    private String subject
    private BodySpec bodySpec

    void from(String from) { this.from = from }

    void to(String... to) { this.to = to }

    void subject(String subject) { this.subject = subject }

    void body(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = BodySpec) Closure body) {
        def bodySpec = new BodySpec()
        def code = body.rehydrate(bodySpec, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        this.bodySpec = bodySpec
    }

    def email(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = EmailSpec) Closure cl) {
        def email = new EmailSpec()
        def code = cl.rehydrate(email, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        return email
    }

    def sendEmail() {
        return email {
            from 'dsl-guru@mycompany.com'
            to 'john.doe@waitaminute.com', 'dauren.mussa@gmail.com'
            subject 'The pope has resigned!'
            body {
                p 'Really, the pope has resigned!'
            }
        }
    }

    static void main(String[] args) {
        EmailSpec spec = new EmailSpec()
        println spec.sendEmail()
    }


    @Override
    String toString() {
        JsonBuilder builder = new JsonBuilder()
        builder {
            fromEmail this.from
            toEmail this.to
            subjectEmail this.subject
            bodyEmail this.bodySpec
        }
        return JsonOutput.prettyPrint(builder.toString())
    }
}
