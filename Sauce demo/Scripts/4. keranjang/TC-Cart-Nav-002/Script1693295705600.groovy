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

WebUI.callTestCase(findTestCase('4. keranjang/TC-Cart-Show-002'), [:], FailureHandling.STOP_ON_FAILURE)

nmPro = WebUI.getText(findTestObject('Object Repository/keranjang/div_Sauce Labs Backpack'))
desc = WebUI.getText(findTestObject('Object Repository/keranjang/desc produk 1 di keranjang'))
harga = WebUI.getText(findTestObject('Object Repository/keranjang/harga produk 1 di keranjang'))

WebUI.click(findTestObject('keranjang/nama produk 1'))

namaProduk = WebUI.getText(findTestObject('Object Repository/keranjang/nm produk detail produk'))
desc = WebUI.getText(findTestObject('Object Repository/keranjang/desc produk di detail produk'))
price = WebUI.getText(findTestObject('Object Repository/keranjang/harga produk 1 di detail produk'))

assert nmPro == namaProduk
assert desc == desc
assert harga == price

