package com.diegopalvarez.oreplay.domain.model

interface Result {
    // Common fields for both types of results
    val id: String
    val bibNumber: String?
    val isNc: Boolean
    val eligibility: Boolean?
    val fullName: String

    // Result information
    val stageResult: StageResult?
    val overallResult: Overall?
}