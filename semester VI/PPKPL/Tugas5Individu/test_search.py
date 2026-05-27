from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

import time


# =========================================================
# DATA SEARCH
# =========================================================

VALID_PRODUCT = "shirt"
LOWERCASE_PRODUCT = "shirt"
UPPERCASE_PRODUCT = "SHIRT"
PARTIAL_PRODUCT = "shi"

INVALID_PRODUCT = "produk_tidak_ada"
SYMBOL_PRODUCT = "@#$%^&"
SPACE_PRODUCT = " "
LONG_PRODUCT = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"


# =========================================================
# HELPER FUNCTION
# =========================================================

def setup_driver():

    driver = webdriver.Chrome(
        service=Service(ChromeDriverManager().install())
    )

    driver.get("https://askomdch.com/store/")

    driver.maximize_window()

    wait = WebDriverWait(driver, 10)

    return driver, wait


# =========================================================
# POSITIVE TEST CASE
# =========================================================

# TC_SRC_01_POS
# Search produk valid
def test_search_valid_product():

    driver, wait = setup_driver()

    try:

        search_input = wait.until(
            EC.presence_of_element_located((By.ID, "woocommerce-product-search-field-0"))
        )
        search_input.send_keys(VALID_PRODUCT)

        search_button = driver.find_element(By.CSS_SELECTOR,"button[value='Search']")
        search_button.click()

        time.sleep(3)

        result_text = wait.until(
            EC.presence_of_element_located(
                (By.CLASS_NAME, "woocommerce-result-count")
            )
        ).text

        assert "Showing all 2 results" in result_text

        print("TC_SRC_01_POS PASSED")

    except Exception as e:

        print("TC_SRC_01_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_SRC_02_POS
# Search dengan huruf kecil
def test_search_lowercase_product():

    driver, wait = setup_driver()

    try:

        search_input = wait.until(
            EC.presence_of_element_located((By.ID, "woocommerce-product-search-field-0"))
        )
        search_input.send_keys(LOWERCASE_PRODUCT)

        search_button = driver.find_element(By.CSS_SELECTOR,"button[value='Search']")
        search_button.click()

        time.sleep(3)

        result_text = wait.until(
            EC.presence_of_element_located(
                (By.CLASS_NAME, "woocommerce-result-count")
            )
        ).text

        assert "Showing all 2 results" in result_text

        print("TC_SRC_02_POS PASSED")

    except Exception as e:

        print("TC_SRC_02_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_SRC_03_POS
# Search dengan huruf besar
def test_search_uppercase_product():

    driver, wait = setup_driver()

    try:

        search_input = wait.until(
            EC.presence_of_element_located((By.ID, "woocommerce-product-search-field-0"))
        )
        search_input.send_keys(UPPERCASE_PRODUCT)

        search_button = driver.find_element(By.CSS_SELECTOR,"button[value='Search']")
        search_button.click()

        time.sleep(3)

        result_text = wait.until(
            EC.presence_of_element_located(
                (By.CLASS_NAME, "woocommerce-result-count")
            )
        ).text

        assert "Showing all 2 results" in result_text

        print("TC_SRC_03_POS PASSED")

    except Exception as e:

        print("TC_SRC_03_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_SRC_04_POS
# Search nama produk sebagian
def test_search_partial_product():

    driver, wait = setup_driver()

    try:

        search_input = wait.until(
            EC.presence_of_element_located((By.ID, "woocommerce-product-search-field-0"))
        )
        search_input.send_keys(PARTIAL_PRODUCT)

        search_button = driver.find_element(By.CSS_SELECTOR,"button[value='Search']")
        search_button.click()

        time.sleep(3)

        result_text = wait.until(
            EC.presence_of_element_located(
                (By.CLASS_NAME, "woocommerce-result-count")
            )
        ).text

        assert "Showing all 2 results" in result_text

        print("TC_SRC_04_POS PASSED")

    except Exception as e:

        print("TC_SRC_04_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_SRC_05_POS
# Search menggunakan tombol ENTER
def test_search_with_enter():

    driver, wait = setup_driver()

    try:

        search_input = wait.until(
            EC.presence_of_element_located((By.ID, "woocommerce-product-search-field-0"))
        )
        search_input.send_keys(VALID_PRODUCT)
        search_input.send_keys(Keys.ENTER)

        time.sleep(3)

        result_text = wait.until(
            EC.presence_of_element_located(
                (By.CLASS_NAME, "woocommerce-result-count")
            )
        ).text

        assert "Showing all 2 results" in result_text

        print("TC_SRC_05_POS PASSED")

    except Exception as e:

        print("TC_SRC_05_POS FAILED")
        print(e)

    finally:

        driver.quit()


# =========================================================
# NEGATIVE TEST CASE
# =========================================================

# TC_SRC_01_NEG
# Search kosong
def test_search_empty_input():

    driver, wait = setup_driver()

    try:

        search_input = wait.until(
            EC.presence_of_element_located((By.ID, "woocommerce-product-search-field-0"))
        )
        search_input.clear()

        search_button = driver.find_element(By.CSS_SELECTOR,"button[value='Search']")
        search_button.click()

        time.sleep(3)

        assert "No products were found" in driver.page_source

        print("TC_SRC_01_NEG PASSED")

    except Exception as e:

        print("TC_SRC_01_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_SRC_02_NEG
# Search produk tidak tersedia
def test_search_invalid_product():

    driver, wait = setup_driver()

    try:

        search_input = wait.until(
            EC.presence_of_element_located((By.ID, "woocommerce-product-search-field-0"))
        )
        search_input.send_keys(INVALID_PRODUCT)

        search_button = driver.find_element(By.CSS_SELECTOR,"button[value='Search']")
        search_button.click()

        time.sleep(3)

        assert "No products were found" in driver.page_source

        print("TC_SRC_02_NEG PASSED")

    except Exception as e:

        print("TC_SRC_02_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_SRC_03_NEG
# Search dengan karakter simbol
def test_search_symbol_product():

    driver, wait = setup_driver()

    try:

        search_input = wait.until(
            EC.presence_of_element_located((By.ID, "woocommerce-product-search-field-0"))
        )
        search_input.send_keys(SYMBOL_PRODUCT)

        search_button = driver.find_element(By.CSS_SELECTOR,"button[value='Search']")
        search_button.click()

        time.sleep(3)

        assert "No products were found" in driver.page_source

        print("TC_SRC_03_NEG PASSED")

    except Exception as e:

        print("TC_SRC_03_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_SRC_04_NEG
# Search dengan spasi kosong
def test_search_space_input():

    driver, wait = setup_driver()

    try:

        search_input = wait.until(
            EC.presence_of_element_located((By.ID, "woocommerce-product-search-field-0"))
        )
        search_input.send_keys(SPACE_PRODUCT)

        search_button = driver.find_element(By.CSS_SELECTOR,"button[value='Search']")
        search_button.click()

        time.sleep(3)

        assert "No products were found" in driver.page_source

        print("TC_SRC_04_NEG PASSED")

    except Exception as e:

        print("TC_SRC_04_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_SRC_05_NEG
# Search dengan karakter sangat panjang
def test_search_long_input():

    driver, wait = setup_driver()

    try:

        search_input = wait.until(
            EC.presence_of_element_located((By.ID, "woocommerce-product-search-field-0"))
        )
        search_input.send_keys(LONG_PRODUCT)

        search_button = driver.find_element(By.CSS_SELECTOR,"button[value='Search']")
        search_button.click()

        time.sleep(3)

        assert "No products were found" in driver.page_source

        print("TC_SRC_05_NEG PASSED")

    except Exception as e:

        print("TC_SRC_05_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# =========================================================
# MENJALANKAN SEMUA TEST
# =========================================================

test_search_valid_product()
test_search_lowercase_product()
test_search_uppercase_product()
test_search_partial_product()
test_search_with_enter()

test_search_empty_input()
test_search_invalid_product()
test_search_symbol_product()
test_search_space_input()
test_search_long_input()