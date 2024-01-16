import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('2. Products/TC-Product-Show-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Products/dropdown fillter'), 'az', false)

//ambil semua element dari nama produk
List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Products/nama semua produk'), 10)

//deklaasi dua array
String[] arrProdukNameOri = new String[dataList.size()]
String[] arrProdukNameSort = new String[dataList.size()]

//deklarasi dua array
for(int i = 0 ; i<dataList.size(); i++) {
	text = dataList.get(i).text
	arrProdukNameOri[i] = text
	arrProdukNameSort[i] = text
}

//sort array
Arrays.sort(arrProdukNameSort)

println arrProdukNameOri
println arrProdukNameSort

assert arrProdukNameOri == arrProdukNameSort
