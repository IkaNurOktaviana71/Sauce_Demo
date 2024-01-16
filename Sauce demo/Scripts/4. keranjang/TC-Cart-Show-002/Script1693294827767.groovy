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

HashMap<String,Object> dataProduk = WebUI.callTestCase(findTestCase('2. Products/TC-Product-AddCart-001'), [:], FailureHandling.STOP_ON_FAILURE)
produk = dataProduk.get("namaProduk")
Deskripsi = dataProduk.get("deskripsi")
price = dataProduk.get("price")

WebUI.click(findTestObject('keranjang/keranjang belanja'))

WebUI.verifyElementPresent(findTestObject('keranjang/div_Your Cart'), 0)


namaProduk = WebUI.getText(findTestObject('Object Repository/keranjang/nama produk'))
deskripsi = WebUI.getText(findTestObject('Object Repository/keranjang/deskripsi'))
harga = WebUI.getText(findTestObject('Object Repository/keranjang/harga'))

assert namaProduk.toString().trim().equalsIgnoreCase(produk.trim())
assert deskripsi.toString().trim().equalsIgnoreCase(Deskripsi.trim())
assert harga.toString().trim().equalsIgnoreCase(price.trim())


HashMap<String, Object> dataKeranjang = new HashMap();
dataKeranjang.put("namaProduk", namaProduk)
dataKeranjang.put("deskripsi", deskripsi)
dataKeranjang.put("harga",harga)

return dataKeranjang

