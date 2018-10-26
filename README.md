# helloFresh qa-automation challenge Pablo Calvo
Pablo Calvo
pjcalvov@gmail.com
skypeid pjcalvovargas

# Improvements done
* switch jUnit for TestNg so that test parallelization, test organization and test reporting are now available out of the box
* made the code thread safe so that we can run tests in parallel
* parallelized the executed based on test suites
* organized the code in Helpers, Models, Pages and Specs packages, to reuse code and reduce maintenance effort
* created a BaseClass with the common methods (Setup and TearDown)
* screenshots are taken if the test fails
* created a SuperBaseClass to organize the Pages and move the ugly code out of the tests tier
* created a DataProvider that read the user information from a csv file
* now it uses webdriverextensions-maven-plugin to download the drives and so we can remove the chromedriver from the repository
* it uses a Enum class to define which payment wants to choose (just for fun)
* it uses PageFactory to construct the objects (it is supposed to be more efficent)
* user javascript to scrool the element into view and then actions to move the mouse and click the selected product from the list (there was a bug in chrome where double clicking was necessary)

# running the tests
*The project is Java with Maven so that it could be easily runned by the reviewer
