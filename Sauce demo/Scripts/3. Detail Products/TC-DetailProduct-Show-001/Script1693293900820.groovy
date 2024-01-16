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

WebUI.callTestCase(findTestCase('1. login/TC-Login-Success-001'), [:], FailureHandling.STOP_ON_FAILURE)


// menyimpan variabel yang ada di halaman produk
nmProduk = WebUI.getText(findTestObject('Object Repository/1. Login/nama produk1 di halaman produk'))
desc = WebUI.getText(findTestObject('Object Repository/1. Login/deskripsi produk 1 di produk'))
harga = WebUI.getText(findTestObject('Object Repository/1. Login/harga produk 1 di halaman produk'))


//untuk melihat detail produk
WebUI.click(findTestObject('Detail Product/produk 1'))

//untuk menympan di variabel untuk yang di halaman detail produk
namaProduk = WebUI.getText(findTestObject('Object Repository/Detail Product/nama produk 1'))

deskripsi = WebUI.getText(findTestObject('Object Repository/Detail Product/deskripsi produk 1'))

price = WebUI.getText(findTestObject('Object Repository/Detail Product/deskripsi harga produk'))

assert namaProduk.toString().trim().equalsIgnoreCase(nmProduk.trim())

assert deskripsi.toString().trim().equalsIgnoreCase(desc.trim())

assert price.toString().trim().equalsIgnoreCase(harga.trim())


