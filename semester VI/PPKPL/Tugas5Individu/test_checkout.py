from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

import random
import time

def add_product_to_cart(driver):

    driver.get(
        "https://askomdch.com/product/blue-denim-shorts/"
    )

    time.sleep(3)

    add_button = driver.find_element(By.NAME,"add-to-cart")
    add_button.click()

    time.sleep(3)

# =========================================================
# HELPER FUNCTION
# =========================================================

def setup_driver():

    driver = webdriver.Chrome(
        service=Service(ChromeDriverManager().install())
    )


    driver.maximize_window()

    wait = WebDriverWait(driver, 10)

    # Tambahkan produk ke cart
    add_product_to_cart(driver)

    # Membuka halaman checkout
    driver.get("https://askomdch.com/checkout/")

    return driver, wait


# =========================================================
# HELPER INPUT CHECKOUT
# =========================================================

def fill_checkout_form(driver, email="test@gmail.com"):

    random_number = random.randint(1000, 9999)

    driver.find_element(By.ID,"billing_first_name").send_keys("Udin")
    driver.find_element(By.ID,"billing_last_name").send_keys("Testing")
    driver.find_element(By.ID,"billing_company").send_keys("Test Company")
    driver.find_element(By.ID,"billing_address_1").send_keys(f"Street Test {random_number}")
    driver.find_element(By.ID,"billing_city").send_keys("California")
    driver.find_element(By.ID,"billing_postcode").send_keys("70114")
    driver.find_element(By.ID,"billing_phone").send_keys("08123456789")
    driver.find_element(By.ID,"billing_email").send_keys(email)


# =========================================================
# POSITIVE TEST CASE
# =========================================================

# TC_COT_01_POS
# Checkout dengan seluruh data valid
def test_checkout_valid_data():

    driver, wait = setup_driver()

    try:

        fill_checkout_form(driver)

        time.sleep(5)

        driver.find_element(By.ID,"place_order").click()

        time.sleep(5)

        # Validasi checkout berhasil
        assert "Thank you. Your order has been received." in driver.page_source

        print("TC_COT_01_POS PASSED")

    except Exception as e:

        print("TC_COT_01_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_COT_02_POS
# Checkout tanpa field optional
def test_checkout_without_optional_field():

    driver, wait = setup_driver()

    try:

        driver.find_element(By.ID,"billing_first_name").send_keys("Udin")
        driver.find_element(By.ID,"billing_last_name").send_keys("Testing")
        driver.find_element( By.ID,"billing_address_1").send_keys("Street Test")
        driver.find_element(By.ID,"billing_city").send_keys("California")
        driver.find_element(By.ID,"billing_postcode").send_keys("70114")
        driver.find_element(By.ID,"billing_email").send_keys("test@gmail.com")

        time.sleep(5)

        driver.find_element(By.ID,"place_order").click()

        time.sleep(5)

        assert "Thank you. Your order has been received." in driver.page_source

        print("TC_COT_02_POS PASSED")

    except Exception as e:

        print("TC_COT_02_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_COT_03_POS
# Checkout email domain selain gmail
def test_checkout_non_gmail_email():

    driver, wait = setup_driver()

    try:

        fill_checkout_form(driver, email="test@yahoo.com")

        time.sleep(5)

        driver.find_element(By.ID,"place_order").click()

        time.sleep(5)

        assert "Thank you. Your order has been received." in driver.page_source

        print("TC_COT_03_POS PASSED")

    except Exception as e:

        print("TC_COT_03_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_COT_04_POS
# Checkout alamat kombinasi huruf dan angka
def test_checkout_address_combination():

    driver, wait = setup_driver()

    try:

        fill_checkout_form(driver)

        address = driver.find_element(By.ID,"billing_address_1")
        address.clear()
        address.send_keys("Jl Mawar No 123")

        time.sleep(5)

        driver.find_element(By.ID,"place_order").click()

        time.sleep(5)

        assert "Thank you. Your order has been received." in driver.page_source

        print("TC_COT_04_POS PASSED")

    except Exception as e:

        print("TC_COT_04_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_COT_05_POS
# Checkout dengan order notes
def test_checkout_order_notes():

    driver, wait = setup_driver()

    try:

        fill_checkout_form(driver)

        driver.find_element(By.ID,"order_comments").send_keys("Tolong kirim cepat")

        time.sleep(5)

        driver.find_element(By.ID,"place_order").click()

        time.sleep(5)

        assert "Thank you. Your order has been received." in driver.page_source

        print("TC_COT_05_POS PASSED")

    except Exception as e:

        print("TC_COT_05_POS FAILED")
        print(e)

    finally:

        driver.quit()


# =========================================================
# NEGATIVE TEST CASE
# =========================================================

# TC_COT_01_NEG
# First Name kosong
def test_checkout_empty_firstname():

    driver, wait = setup_driver()

    try:

        fill_checkout_form(driver)

        firstname = driver.find_element(By.ID,"billing_first_name")
        firstname.clear()

        time.sleep(5)

        driver.find_element(By.ID,"place_order").click()

        time.sleep(3)

        assert "Billing First name" in driver.page_source

        print("TC_COT_01_NEG PASSED")

    except Exception as e:

        print("TC_COT_01_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_COT_02_NEG
# Last Name kosong
def test_checkout_empty_lastname():

    driver, wait = setup_driver()

    try:

        fill_checkout_form(driver)

        lastname = driver.find_element(By.ID,"billing_last_name")
        lastname.clear()

        time.sleep(5)

        driver.find_element(By.ID,"place_order").click()

        time.sleep(3)

        assert "Billing Last name" in driver.page_source

        print("TC_COT_02_NEG PASSED")

    except Exception as e:

        print("TC_COT_02_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_COT_03_NEG
# Street Address kosong
def test_checkout_empty_address():

    driver, wait = setup_driver()

    try:

        fill_checkout_form(driver)

        address = driver.find_element(By.ID,"billing_address_1")
        address.clear()

        time.sleep(5)

        driver.find_element(By.ID,"place_order").click()

        time.sleep(3)

        assert "Billing Street address" in driver.page_source

        print("TC_COT_03_NEG PASSED")

    except Exception as e:

        print("TC_COT_03_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_COT_04_NEG
# ZIP Code kosong
def test_checkout_empty_zipcode():

    driver, wait = setup_driver()

    try:

        fill_checkout_form(driver)

        zipcode = driver.find_element(By.ID,"billing_postcode")
        zipcode.clear()

        time.sleep(5)

        driver.find_element(By.ID,"place_order").click()

        time.sleep(3)

        assert "Billing ZIP Code" in driver.page_source

        print("TC_COT_04_NEG PASSED")

    except Exception as e:

        print("TC_COT_04_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_COT_05_NEG
# Email kosong
def test_checkout_empty_email():

    driver, wait = setup_driver()

    try:

        fill_checkout_form(driver)

        email = driver.find_element(By.ID,"billing_email")
        email.clear()

        time.sleep(5)

        driver.find_element(By.ID,"place_order").click()

        time.sleep(3)

        assert "Billing Email address" in driver.page_source

        print("TC_COT_05_NEG PASSED")

    except Exception as e:

        print("TC_COT_05_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# =========================================================
# MENJALANKAN SEMUA TEST
# =========================================================

test_checkout_valid_data()
test_checkout_without_optional_field()
test_checkout_non_gmail_email()
test_checkout_address_combination()
test_checkout_order_notes()

test_checkout_empty_firstname()
test_checkout_empty_lastname()
test_checkout_empty_address()
test_checkout_empty_zipcode()
test_checkout_empty_email()