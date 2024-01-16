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
import org.openqa.selenium.Keys as Keys

HashMap<String, Object> dataCart1 = WebUI.callTestCase(findTestCase('2. Products/TC-Product-AddCart-001'), [('produkName') : 'Sauce Labs Backpack', ('deskripsi') : 'carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.'
        , ('price') : '$29.99'], FailureHandling.STOP_ON_FAILURE)
produk = dataCart1.get("namaProduk")
Deskripsi = dataCart1.get("deskripsi")
harga = dataCart1.get("price")

WebUI.click(findTestObject('Products/button_Add to cart'))


//VERIFIKASI BUTTON REMOVE
WebUI.verifyElementPresent(findTestObject('Object Repository/Products/button_Remove'), 0)

namaProduk = WebUI.getText(findTestObject('Object Repository/Products/nama produk 2'))
deskripsi = WebUI.getText(findTestObject('Object Repository/Products/deskripsi produk 2'))
Harga = WebUI.getText(findTestObject('Object Repository/Products/harga produk 2'))

String[] NamaProduk = new String[2];
String[] deskripsiProduk = new String[2]
String[] hargaBarang = new String[2]

for(int i=0 ; i < 2; i++) {
	NamaProduk[0]= produk
	NamaProduk[1] = namaProduk
	deskripsiProduk[0]= Deskripsi
	deskripsiProduk[1] = deskripsi
	hargaBarang[0] = harga
	hargaBarang[1] = Harga
}

HashMap<String,Object> dataProduk2 = new HashMap()
dataProduk2.put("NamaProduk2", NamaProduk)
dataProduk2.put("deskripsiProduk2", deskripsiProduk)
dataProduk2.put("hargaBarang2", hargaBarang)

return dataProduk2

WebUI.verifyElementPresent(findTestObject('Products/shopping cart 1'), 0)

badge = WebUI.getText(findTestObject('Object Repository/Products/angka di keranjang'))

assert badge == '2'