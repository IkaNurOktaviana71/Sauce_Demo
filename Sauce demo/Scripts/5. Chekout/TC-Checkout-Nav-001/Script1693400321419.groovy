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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('4. keranjang/TC-Cart-Show-002'), [('namaProduk') : 'Sauce Labs Backpack'
        , ('deskripsi') : 'carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.'
        , ('harga') : '$29.99'], FailureHandling.STOP_ON_FAILURE)

nProduk = data.get('namaProduk')

desc = data.get('deskripsi')

price = data.get('harga')

WebUI.click(findTestObject('chekout/button_Checkout'))

WebUI.verifyElementPresent(findTestObject('chekout/step 1 Checkout Your Information'), 0)

WebUI.setText(findTestObject('chekout/input_firstName_Checkout Your Information'), 'Ika')

WebUI.setText(findTestObject('chekout/input_lastName_Checkout Your Information'), 'Nur')

WebUI.setText(findTestObject('chekout/input_postalCode_Checkout Your Information'), '55582')

WebUI.click(findTestObject('chekout/continue (your Information)'))

WebUI.verifyElementPresent(findTestObject('chekout/span_Checkout Overview'), 0)

produk = WebUI.getText(findTestObject('Object Repository/chekout/nama produk 1'))

descr = WebUI.getText(findTestObject('Object Repository/chekout/deksripsi produk 1'))

Harga = WebUI.getText(findTestObject('Object Repository/chekout/harga produk 1'))

assert nProduk == produk

assert desc == descr

assert price == Harga

String[] tax = WebUI.getText(findTestObject('Object Repository/chekout/tax')).split('\\$')

newTax = Double.parseDouble(tax[1])

String[] total = WebUI.getText(findTestObject('Object Repository/chekout/item total')).split('\\$')

totalHarga = Double.parseDouble(total[1])

//menghitung harga dan tax
String[] text = WebUI.getText(findTestObject('Object Repository/chekout/item total')).split('\\$')

hargaNew = Double.parseDouble(text[1])

hitTax = (hargaNew * 0.08)

hitTax = (Math.round(hitTax * 100) / 100)

hitTotal = (hargaNew + hitTax)

// menngubah tottal harga

String[] sum = WebUI.getText(findTestObject('Object Repository/chekout/total harga')).split('\\$')
sumPrice = Double.parseDouble(sum[1])


assert newTax == hitTax

assert sumPrice == hitTotal

WebUI.click(findTestObject('chekout/button_Finish'))

WebUI.verifyElementText(findTestObject('chekout/h2_Thank you for your order'), 'Thank you for your order!')

