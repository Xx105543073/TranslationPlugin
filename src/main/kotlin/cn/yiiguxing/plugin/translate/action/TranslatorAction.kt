package cn.yiiguxing.plugin.translate.action

import cn.yiiguxing.plugin.translate.ui.settings.TranslationEngine
import cn.yiiguxing.plugin.translate.util.Settings
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.openapi.util.Condition

/**
 * TranslatorAction
 */
class TranslatorAction(private val translator: TranslationEngine) :
    DumbAwareAction(translator.name, null, translator.icon) {

    override fun actionPerformed(e: AnActionEvent) {
        Settings.translator = translator
    }

    companion object {
        val ACTIONS: List<TranslatorAction> = TranslationEngine.values().toList().map { TranslatorAction(it) }

        val PRESELECT_CONDITION: Condition<AnAction> = Condition { action ->
            (action as? TranslatorAction)?.translator == Settings.translator
        }
    }
}