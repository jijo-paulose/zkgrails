# Design of ZKGrails' Model-View-Presenter #

```
class ActivityMapper {
  "#!/:activity" {
   }
}

// some time we may have:
// "#!/hello/chanwit" -> tokenized by /:activity/:name, so params.name = "chanwit"

// Composer in ZK means a view composer
// which is a part of view(V) in MVP.
class HelloComposer {

  //
  // injection of activities seems to not be necessary
  //
  // def helloActivity
  // def goodByeActivity

  def txtName

  def onClick_btnHello() {
    goto(place:"hello", params:[name: txtName.value])
    // like render,
    // resolve "hello" to helloActivity
    // then pass params to it
  }

  def onClick_btnGoodbye() {
    goto(place:"goodbye")
    // same as above
  }
}

class HelloActivity extends GrailsPresenter {

    // injected
    def clientFactory
    def helloPlace
    def eventBus
    def placeController

    // this should be the default behaviour in GrailsPresenter?
    def goto(place) {
       placeController.goto(place)
    }

    // fire PlaceChange
    def start = { container ->
        def c = cf.composer // view composer, should be injected ?
        def c.name = name
        // view (composer) and presenter are bi-directional
        def c.presenter = this // injected, not required?
        // probably the main logic is here
        container.src = composer.viewURL
        fireEvent(...)
    }
    // fire PlaceChangeRequest
    def stop = {
    }  
}

// PlaceHistoryMapper maps a history token to a Place

// Multiple Views -> use Grails Controller to select ZUL View by detecting UA

```