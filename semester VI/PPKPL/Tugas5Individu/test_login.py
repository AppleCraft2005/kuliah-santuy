from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

import time


# =========================================================
# DATA LOGIN VALID
# =========================================================

VALID_USERNAME = "udintest2005"
VALID_EMAIL = "udintest2005@gmail.com"
VALID_PASSWORD = "_ udintest2005 _"


# =========================================================
# HELPER FUNCTION
# =========================================================

def setup_driver():

    driver = webdriver.Chrome(
        service=Service(ChromeDriverManager().install())
    )

    driver.get("https://askomdch.com/account/")

    driver.maximize_window()

    wait = WebDriverWait(driver, 10)

    return driver, wait


# =========================================================
# POSITIVE TEST CASE
# =========================================================

# TC_LGN_01_POS
# Login dengan username dan password valid
def test_login_valid_username():

    driver, wait = setup_driver()

    try:

        username_input = wait.until(
            EC.presence_of_element_located((By.ID, "username"))
        )
        username_input.send_keys(VALID_USERNAME)

        password_input = driver.find_element(By.ID,"password")
        password_input.send_keys(VALID_PASSWORD)

        login_button = driver.find_element(By.NAME,"login")
        login_button.click()

        time.sleep(5)

        success_text = wait.until(
            EC.presence_of_element_located((By.TAG_NAME, "body"))
        ).text

        assert f"Hello {VALID_USERNAME}" in success_text

        print("TC_LGN_01_POS PASSED")

    except Exception as e:

        print("TC_LGN_01_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_LGN_02_POS
# Login dengan email dan password valid
def test_login_valid_email():

    driver, wait = setup_driver()

    try:

        username_input = wait.until(
            EC.presence_of_element_located((By.ID, "username"))
        )
        username_input.send_keys(VALID_EMAIL)

        password_input = driver.find_element(By.ID,"password")
        password_input.send_keys(VALID_PASSWORD)

        login_button = driver.find_element(By.NAME,"login")
        login_button.click()

        time.sleep(5)

        success_text = wait.until(
            EC.presence_of_element_located((By.TAG_NAME, "body"))
        ).text

        assert f"Hello {VALID_USERNAME}" in success_text

        print("TC_LGN_02_POS PASSED")

    except Exception as e:

        print("TC_LGN_02_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_LGN_03_POS
# Login dengan username huruf kecil
def test_login_lowercase_username():

    driver, wait = setup_driver()

    try:

        username_input = wait.until(
            EC.presence_of_element_located((By.ID, "username"))
        )
        username_input.send_keys("udintest2005")

        password_input = driver.find_element(By.ID,"password")
        password_input.send_keys(VALID_PASSWORD)

        login_button = driver.find_element(By.NAME,"login")
        login_button.click()

        time.sleep(5)

        success_text = wait.until(
            EC.presence_of_element_located((By.TAG_NAME, "body"))
        ).text

        assert f"Hello {VALID_USERNAME}" in success_text

        print("TC_LGN_03_POS PASSED")

    except Exception as e:

        print("TC_LGN_03_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_LGN_04_POS
# Login dengan username kombinasi angka
def test_login_username_with_number():

    driver, wait = setup_driver()

    try:

        username_input = wait.until(
            EC.presence_of_element_located((By.ID, "username"))
        )
        username_input.send_keys("udintest2005")

        password_input = driver.find_element(By.ID,"password")
        password_input.send_keys(VALID_PASSWORD)

        login_button = driver.find_element(By.NAME,"login")
        login_button.click()

        time.sleep(5)

        success_text = wait.until(
            EC.presence_of_element_located((By.TAG_NAME, "body"))
        ).text

        assert f"Hello {VALID_USERNAME}" in success_text

        print("TC_LGN_04_POS PASSED")

    except Exception as e:

        print("TC_LGN_04_POS FAILED")
        print(e)

    finally:

        driver.quit()


# TC_LGN_05_POS
# Login dengan password kombinasi karakter
def test_login_password_combination():

    driver, wait = setup_driver()

    try:

        username_input = wait.until(
            EC.presence_of_element_located((By.ID, "username"))
        )
        username_input.send_keys(VALID_USERNAME)

        password_input = driver.find_element(By.ID,"password")
        password_input.send_keys(VALID_PASSWORD)

        login_button = driver.find_element(By.NAME,"login")
        login_button.click()

        time.sleep(5)

        success_text = wait.until(
            EC.presence_of_element_located((By.TAG_NAME, "body"))
        ).text

        assert f"Hello {VALID_USERNAME}" in success_text

        print("TC_LGN_05_POS PASSED")

    except Exception as e:

        print("TC_LGN_05_POS FAILED")
        print(e)

    finally:

        driver.quit()


# =========================================================
# NEGATIVE TEST CASE
# =========================================================

# TC_LGN_01_NEG
# Username kosong
def test_login_empty_username():

    driver, wait = setup_driver()

    try:

        password_input = wait.until(
            EC.presence_of_element_located((By.ID, "password"))
        )
        password_input.send_keys(VALID_PASSWORD)

        login_button = driver.find_element(By.NAME,"login")
        login_button.click()

        time.sleep(3)

        assert "Username is required" in driver.page_source

        print("TC_LGN_01_NEG PASSED")

    except Exception as e:

        print("TC_LGN_01_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_LGN_02_NEG
# Password kosong
def test_login_empty_password():

    driver, wait = setup_driver()

    try:

        username_input = wait.until(
            EC.presence_of_element_located((By.ID, "username"))
        )
        username_input.send_keys(VALID_USERNAME)

        login_button = driver.find_element(By.NAME,"login")
        login_button.click()

        time.sleep(3)

        assert "The password field is empty" in driver.page_source

        print("TC_LGN_02_NEG PASSED")

    except Exception as e:

        print("TC_LGN_02_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_LGN_03_NEG
# Username salah
def test_login_invalid_username():

    driver, wait = setup_driver()

    try:

        username_input = wait.until(
            EC.presence_of_element_located((By.ID, "username"))
        )
        username_input.send_keys("username_salah")

        password_input = driver.find_element(By.ID,"password")
        password_input.send_keys(VALID_PASSWORD)

        login_button = driver.find_element(By.NAME,"login")
        login_button.click()

        time.sleep(3)

        assert "is not registered on this site" in driver.page_source

        print("TC_LGN_03_NEG PASSED")

    except Exception as e:

        print("TC_LGN_03_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_LGN_04_NEG
# Email salah
def test_login_invalid_email():

    driver, wait = setup_driver()

    try:

        username_input = wait.until(
            EC.presence_of_element_located(
                (By.ID, "username")
            )
        )
        username_input.send_keys("emailsalah@gmail.com")

        password_input = driver.find_element(By.ID,"password") 
        password_input.send_keys(VALID_PASSWORD)

        login_button = driver.find_element(By.NAME,"login")
        login_button.click()

        time.sleep(3)

        assert "Unknown email address" in driver.page_source

        print("TC_LGN_04_NEG PASSED")

    except Exception as e:

        print("TC_LGN_04_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# TC_LGN_05_NEG
# Password salah
def test_login_invalid_password():

    driver, wait = setup_driver()

    try:

        username_input = wait.until(
            EC.presence_of_element_located((By.ID, "username"))
        )
        username_input.send_keys(VALID_USERNAME)

        password_input = driver.find_element(By.ID,"password")
        password_input.send_keys("password_salah")

        login_button = driver.find_element(By.NAME,"login")
        login_button.click()

        time.sleep(3)

        assert "Lost your password?" in driver.page_source

        print("TC_LGN_05_NEG PASSED")

    except Exception as e:

        print("TC_LGN_05_NEG FAILED")
        print(e)

    finally:

        driver.quit()


# =========================================================
# MENJALANKAN SEMUA TEST
# =========================================================

test_login_valid_username()
test_login_valid_email()
test_login_lowercase_username()
test_login_username_with_number()
test_login_password_combination()

test_login_empty_username()
test_login_empty_password()
test_login_invalid_username()
test_login_invalid_email()
test_login_invalid_password()