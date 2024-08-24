package org.achumkin

import com.microsoft.playwright.*
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.api.TestInstance.Lifecycle

@TestInstance(Lifecycle.PER_CLASS)
class NginxTest {

    private lateinit var playwright: Playwright
    private lateinit var browser: Browser
    private lateinit var page: Page
    private val baseUrl = getRequiredEnv("NGINX_BASE_URL")

    @BeforeAll
    fun setUp() {
        playwright = Playwright.create()
        browser = playwright.chromium().launch(BrowserType.LaunchOptions().setHeadless(false))
        page = browser.newPage()
        page.navigate(baseUrl)
    }

    @AfterAll
    fun tearDown() {
        browser.close()
        playwright.close()
    }

    @Test
    fun `verify header text`() {
        assertThat(page.locator("h1")).hasText("Welcome to nginx!")
    }

    @Test
    fun `verify link`() {
        assertThat(page.getByText("nginx.com").first()).hasAttribute("href", "http://nginx.com/")
    }

}
