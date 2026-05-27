from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

import random
import time


# =========================================================
# Helper Function
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

# TC_RGS_01_POS
# Register dengan data valid
def test_register_valid():

    random_number = random.randint(1000, 9999)

    username = f"User{random_number}"
    email = f"user{random_number}@test.com"
    password = "Test12345!"

    driver, wait = setup_driver()

    try:

        username_input = wait.until(
            EC.presence_of_element_located((By.ID, "reg_username"))
        )
        username_input.send_keys(username)

        driver.find_element(By.ID, "reg_email").send_keys(email)

        driver.find_element(By.ID, "reg_password").send_keys(password)

        driver.find_element(By.NAME, "register").click()

        time.sleep(5)

        success_text = wait.until(
            EC.presence_of_element_located((By.TAG_NAME, "body"))
        ).text

        assert f"Hello {username}" in success_text

        print("TC_RGS_01_POS PASSED")

    except Exception as e:
        print("TC_RGS_01_POS FAILED")
        print(e)

    finally:
        driver.quit()


# TC_RGS_02_POS
# Register dengan username huruf kecil
def test_register_lowercase_username():

    random_number = random.randint(1000, 9999)

    username = f"user{random_number}"
    email = f"userlower{random_number}@test.com"
    password = "Test12345!"

    driver, wait = setup_driver()

    try:

        wait.until(
            EC.presence_of_element_located((By.ID, "reg_username"))
        ).send_keys(username)

        driver.find_element(By.ID, "reg_email").send_keys(email)

        driver.find_element(By.ID, "reg_password").send_keys(password)

        driver.find_element(By.NAME, "register").click()

        time.sleep(5)

        success_text = wait.until(
            EC.presence_of_element_located((By.TAG_NAME, "body"))
        ).text

        assert f"Hello {username}" in success_text

        print("TC_RGS_02_POS PASSED")

    except Exception as e:
        print("TC_RGS_02_POS FAILED")
        print(e)

    finally:
        driver.quit()


# TC_RGS_03_POS
# Register dengan username kombinasi angka
def test_register_username_with_number():

    random_number = random.randint(1000, 9999)

    username = f"user123{random_number}"
    email = f"usernumber{random_number}@test.com"
    password = "Test12345!"

    driver, wait = setup_driver()

    try:

        wait.until(
            EC.presence_of_element_located((By.ID, "reg_username"))
        ).send_keys(username)

        driver.find_element(By.ID, "reg_email").send_keys(email)

        driver.find_element(By.ID, "reg_password").send_keys(password)

        driver.find_element(By.NAME, "register").click()

        time.sleep(5)

        success_text = wait.until(
            EC.presence_of_element_located((By.TAG_NAME, "body"))
        ).text

        assert f"Hello {username}" in success_text

        print("TC_RGS_03_POS PASSED")

    except Exception as e:
        print("TC_RGS_03_POS FAILED")
        print(e)

    finally:
        driver.quit()


# TC_RGS_04_POS
# Register dengan domain email selain gmail
def test_register_non_gmail_email():

    random_number = random.randint(1000, 9999)

    username = f"User{random_number}"
    email = f"user{random_number}@yahoo.com"
    password = "Test12345!"

    driver, wait = setup_driver()

    try:

        wait.until(
            EC.presence_of_element_located((By.ID, "reg_username"))
        ).send_keys(username)

        driver.find_element(By.ID, "reg_email").send_keys(email)

        driver.find_element(By.ID, "reg_password").send_keys(password)

        driver.find_element(By.NAME, "register").click()

        time.sleep(5)

        success_text = wait.until(
            EC.presence_of_element_located((By.TAG_NAME, "body"))
        ).text

        assert f"Hello {username}" in success_text

        print("TC_RGS_04_POS PASSED")

    except Exception as e:
        print("TC_RGS_04_POS FAILED")
        print(e)

    finally:
        driver.quit()


# TC_RGS_05_POS
# Register dengan password kombinasi karakter
def test_register_password_combination():

    random_number = random.randint(1000, 9999)

    username = f"User{random_number}"
    email = f"usercombo{random_number}@test.com"
    password = "Test@123ABC"

    driver, wait = setup_driver()

    try:

        wait.until(
            EC.presence_of_element_located((By.ID, "reg_username"))
        ).send_keys(username)

        driver.find_element(By.ID, "reg_email").send_keys(email)

        driver.find_element(By.ID, "reg_password").send_keys(password)

        driver.find_element(By.NAME, "register").click()

        time.sleep(5)

        success_text = wait.until(
            EC.presence_of_element_located((By.TAG_NAME, "body"))
        ).text

        assert f"Hello {username}" in success_text

        print("TC_RGS_05_POS PASSED")

    except Exception as e:
        print("TC_RGS_05_POS FAILED")
        print(e)

    finally:
        driver.quit()


# =========================================================
# NEGATIVE TEST CASE
# =========================================================

# TC_RGS_01_NEG
# Username kosong
def test_register_empty_username():

    random_number = random.randint(1000, 9999)

    email = f"user{random_number}@test.com"
    password = "Test12345!"

    driver, wait = setup_driver()

    try:

        driver.find_element(By.ID, "reg_email").send_keys(email)

        driver.find_element(By.ID, "reg_password").send_keys(password)

        driver.find_element(By.NAME, "register").click()

        time.sleep(3)

        assert "Please enter a valid account username" in driver.page_source

        print("TC_RGS_01_NEG PASSED")

    except Exception as e:
        print("TC_RGS_01_NEG FAILED")
        print(e)

    finally:
        driver.quit()


# TC_RGS_02_NEG
# Email kosong
def test_register_empty_email():

    random_number = random.randint(1000, 9999)

    username = f"User{random_number}"
    password = "Test12345!"

    driver, wait = setup_driver()

    try:

        wait.until(
            EC.presence_of_element_located((By.ID, "reg_username"))
        ).send_keys(username)

        driver.find_element(By.ID, "reg_password").send_keys(password)

        driver.find_element(By.NAME, "register").click()

        time.sleep(3)

        assert "Please provide a valid email address" in driver.page_source

        print("TC_RGS_02_NEG PASSED")

    except Exception as e:
        print("TC_RGS_02_NEG FAILED")
        print(e)

    finally:
        driver.quit()


# TC_RGS_03_NEG
# Email tanpa simbol @
def test_register_email_without_at():

    random_number = random.randint(1000, 9999)

    username = f"User{random_number}"
    email = f"user{random_number}test.com"
    password = "Test12345!"

    driver, wait = setup_driver()

    try:
        wait.until(
            EC.presence_of_element_located((By.ID, "reg_username"))
        ).send_keys(username)

        email_input = driver.find_element(By.ID, "reg_email")
        email_input.send_keys(email)

        driver.find_element(By.ID, "reg_password").send_keys(password)

        driver.find_element(By.NAME, "register").click()

        validation_message = email_input.get_attribute(
            "validationMessage"
        )
        assert "Please include an '@' in the email address" in validation_message

        print("TC_RGS_03_NEG PASSED")

    except Exception as e:
        print("TC_RGS_03_NEG FAILED")
        print(e)

    finally:
        driver.quit()

# TC_RGS_04_NEG
# Password kosong
def test_register_empty_password():

    random_number = random.randint(1000, 9999)

    username = f"User{random_number}"
    email = f"user{random_number}@test.com"

    driver, wait = setup_driver()

    try:

        wait.until(
            EC.presence_of_element_located((By.ID, "reg_username"))
        ).send_keys(username)

        driver.find_element(By.ID, "reg_email").send_keys(email)

        driver.find_element(By.NAME, "register").click()

        time.sleep(3)

        assert "Please enter an account password" in driver.page_source

        print("TC_RGS_04_NEG PASSED")

    except Exception as e:
        print("TC_RGS_04_NEG FAILED")
        print(e)

    finally:
        driver.quit()


# TC_RGS_05_NEG
# Password kurang dari 8 karakter
def test_register_short_password():

    random_number = random.randint(1000, 9999)

    username = f"User{random_number}"
    email = f"user{random_number}@test.com"
    password = "123"

    driver, wait = setup_driver()

    try:

        wait.until(
            EC.presence_of_element_located((By.ID, "reg_username"))
        ).send_keys(username)

        driver.find_element(By.ID, "reg_email").send_keys(email)

        driver.find_element(By.ID, "reg_password").send_keys(password)

        driver.find_element(By.NAME, "register").click()

        time.sleep(3)

        assert "Weak password" in driver.page_source

        print("TC_RGS_05_NEG PASSED")

    except Exception as e:
        print("TC_RGS_05_NEG FAILED")
        print(e)

    finally:
        driver.quit()


# =========================================================
# MENJALANKAN SEMUA TEST
# =========================================================

test_register_valid()
test_register_lowercase_username()
test_register_username_with_number()
test_register_non_gmail_email()
test_register_password_combination()

test_register_empty_username()
test_register_empty_email()
test_register_email_without_at()
test_register_empty_password()
test_register_short_password()