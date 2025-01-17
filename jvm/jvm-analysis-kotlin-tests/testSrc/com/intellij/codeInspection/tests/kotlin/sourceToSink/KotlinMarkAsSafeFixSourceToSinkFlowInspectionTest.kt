package com.intellij.codeInspection.tests.kotlin.sourceToSink

import com.intellij.analysis.JvmAnalysisBundle
import com.intellij.codeInspection.tests.sourceToSink.SourceToSinkFlowInspectionTestBase
import com.intellij.jvm.analysis.KotlinJvmAnalysisTestUtil
import com.intellij.testFramework.TestDataPath
import org.jetbrains.annotations.Nls

private const val inspectionPath = "/codeInspection/sourceToSinkFlow/markAsSafeFix"

@TestDataPath("\$CONTENT_ROOT/testData$inspectionPath")
class KotlinMarkAsSafeFixSourceToSinkFlowInspectionTest : SourceToSinkFlowInspectionTestBase() {

  override fun getBasePath() = KotlinJvmAnalysisTestUtil.TEST_DATA_PROJECT_RELATIVE_BASE_PATH + inspectionPath
  fun `test common cases with checkFramework`() {
    prepareCheckFramework()
    myFixture.testQuickFix("CommonCasesCheckFramework.kt", getMessage(), false)
  }

  fun `test common cases with jsr`() {
    prepareJsr()
    myFixture.testQuickFix("CommonCasesJsr.kt", getMessage(), false)
  }

  private fun getMessage(): @Nls String = JvmAnalysisBundle.message("jvm.inspections.source.unsafe.to.sink.flow.mark.as.safe.text")
}