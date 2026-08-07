package com.sekusarisu.yanami

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun komariLiteInstallSourcesAreUsed() {
        val source =
                java.io.File(
                                "src/main/java/com/sekusarisu/yanami/ui/screen/client/ClientInstallCommandDialog.kt"
                        )
                        .readText()
        assertTrue(source.contains("raw.githubusercontent.com/nuomiiiii/komari-agent"))
        assertFalse(source.contains("raw.githubusercontent.com/komari-monitor/komari-agent"))
    }

    @Test
    fun remoteEndpointUsesAdminSessionHandshake() {
        val source =
                java.io.File(
                                "src/main/java/com/sekusarisu/yanami/ui/screen/terminal/SshTerminalViewModel.kt"
                        )
                        .readText()
        assertTrue(source.contains("/api/admin/client/remote"))
        assertTrue(source.contains("session_id"))
        assertTrue(source.contains("browserTicket"))
        assertFalse(source.contains("/api/admin/client/\u0024uuid/terminal"))
    }

    @Test
    fun nodeListExpandedViewIsPersisted() {
        val preferences =
                java.io.File(
                                "src/main/java/com/sekusarisu/yanami/data/local/preferences/UserPreferencesRepository.kt"
                        )
                        .readText()
        val viewModel =
                java.io.File(
                                "src/main/java/com/sekusarisu/yanami/ui/screen/nodelist/NodeListViewModel.kt"
                        )
                        .readText()
        val screen =
                java.io.File(
                                "src/main/java/com/sekusarisu/yanami/ui/screen/nodelist/NodeListScreen.kt"
                        )
                        .readText()

        assertTrue(preferences.contains("node_list_expanded"))
        assertTrue(preferences.contains("setNodeListExpanded"))
        assertTrue(viewModel.contains("nodeListExpanded.collect"))
        assertTrue(viewModel.contains("setNodeListExpanded"))
        assertFalse(screen.contains("var isAllExpanded by remember"))
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}