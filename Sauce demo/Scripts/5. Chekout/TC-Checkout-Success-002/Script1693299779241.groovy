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

HashMap<String,Object> data = WebUI.callTestCase(findTestCase('4. keranjang/TC-Cart-Show-003'), [:], FailureHandling.STOP_ON_FAILURE)
namaProduk = data.get("NamaProduk2")
desc = data.get("deskripsiProduk2")
harga = data.get("hargaBarang2")

WebUI.click(findTestObject('chekout/button_Checkout'))

WebUI.verifyElementPresent(findTestObject('chekout/step 1 Checkout Your Information'), 0)

WebUI.setText(findTestObject('chekout/input_firstName_Checkout Your Information'), 'Ika')

WebUI.setText(findTestObject('chekout/input_lastName_Checkout Your Information'), 'Nur')

WebUI.setText(findTestObject('chekout/input_postalCode_Checkout Your Information'), '55582')

WebUI.click(findTestObject('chekout/continue (your Information)'))

WebUI.verifyElementPresent(findTestObject('chekout/span_Checkout Overview'), 0)


List<WebElement> titleProduk = WebUI.findWebElements(findTestObject('Object Repository/chekout/nama semua produk di overview'), 5)
List<WebElement> descProduk = WebUI.findWebElements(findTestObject('Object Repository/chekout/deskripsi di overview'), 5)
List<WebElement> hargaProduk = WebUI.findWebElements(findTestObject('Object Repository/chekout/harga semua di overview'), 5)

List<String> produk = new ArrayList()
List<String> deskripsi = new ArrayList()
List<String> price = new ArrayList()

for(int i=0; i< titleProduk.size(); i++) {
	TitleProdukText = titleProduk.get(i).text.trim()
	descProdukText = descProduk.get(i).text.trim()
	hargaProdukText = hargaProduk.get(i).text.trim()
	
	produk.add(TitleProdukText)
	deskripsi.add(descProdukText)
	price.add(hargaProdukText)
}

assert namaProduk == produk
assert desc == deskripsi
assert harga == price

Double hargaTotalProduk
Double n=0.0

for(int j=0; j<hargaProduk.size(); j++) {
	text = hargaProduk.get(j).text.replace('$', '')
	tex = Double.parseDouble(text)
	
	n = n + tex
	hargaTotalProduk = n
	println n
}


//menbguah total harga dari string ke number
String[] total = WebUI.getText(findTestObject('Object Repository/chekout/item total')).split('\\$')
itemTotal = Double.parseDouble(total[1])

//mengubah tax dari String ke double
String[] tax=WebUI.getText(findTestObject('Object Repository/chekout/tax')).split('\\$')
taxNew = Double.parseDouble(tax[1])

//menghitung tax 8% dari total harga
hitTax = Math.round((itemTotal*0.08)*100)/100

//menghitung total yang dibayar
hitTotalHarga = itemTotal + hitTax

//mengubah total harga jadi number
String[] sumHarga = WebUI.getText(findTestObject('Object Repository/chekout/total harga')).split('\\$')
sumPrice = Double.parseDouble(sumHarga[1])

//menyamakan total harga dengan total harga perhitungan
assert hargaTotalProduk == itemTotal

//menyamakan apakah total hit total harga dan tax sudah sama
assert sumPrice == hitTotalHarga


WebUI.click(findTestObject('chekout/button_Finish'))

WebUI.verifyElementText(findTestObject('chekout/h2_Thank you for your order'), 'Thank you for your order!')

