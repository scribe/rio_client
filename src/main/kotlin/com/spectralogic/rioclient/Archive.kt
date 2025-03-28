/**
 * ***************************************************************************
 *    Copyright 2014-2021 Spectra Logic Corporation. All Rights Reserved.
 * ***************************************************************************
 */
package com.spectralogic.rioclient

import com.fasterxml.jackson.annotation.JsonInclude
import java.net.URI

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ArchiveRequest(
    val name: String? = null,
    val files: List<FileToArchive>
) : RioRequest

@JsonInclude(JsonInclude.Include.NON_NULL)
data class FileToArchive(
    val name: String,
    val uri: URI,
    val size: Long?,
    val metadata: Map<String, String>? = null,
    val indexMedia: Boolean = false,
    val `upload-new-files-only`: Boolean = true
)
