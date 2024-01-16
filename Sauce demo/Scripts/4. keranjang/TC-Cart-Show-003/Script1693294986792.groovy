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


HashMap<String,Object> dataProduk2 = WebUI.callTestCase(findTestCase('2. Products/TC-Product-AddCart-002'), [:], FailureHandling.STOP_ON_FAILURE)
nmProduk = dataProduk2.get("NamaProduk2")
desc = dataProduk2.get("deskripsiProduk2")
Price = dataProduk2.get("hargaBarang2")

WebUI.click(findTestObject('keranjang/keranjang belanja'))

WebUI.verifyElementPresent(findTestObject('keranjang/div_Your Cart'), 0)


List<WebElement> NamaProdukList = WebUI.findWebElements(findTestObject('Object Repository/keranjang/nama semua produk(keranjang)'), 5)

List<WebElement> DescProdukList = WebUI.findWebElements(findTestObject('Object Repository/keranjang/desc semua produk'), 5)

List<WebElement> hargaProdukList = WebUI.findWebElements(findTestObject('Object Repository/keranjang/harga semua produk'), 5)

List<String> nmProdukOri = new ArrayList();
List<String> descProdukOri = new ArrayList();
List<String> hargaProdukOri = new ArrayList();

for(int i =0 ; i < NamaProdukList.size(); i++) {
	namaText = NamaProdukList.get(i).text.trim()
	descText = DescProdukList.get(i).text.trim()
	hargaText = hargaProdukList.get(i).text.trim()
	
	nmProdukOri.add(namaText)
	descProdukOri.add(descText)
	hargaProdukOri.add(hargaText)
}

assert nmProduk == nmProdukOri
assert desc == descProdukOri
assert Price == hargaProdukOri

return dataProduk2