package com.softwaremill.sttp

import com.softwaremill.sttp.dom.experimental.{File => DomFile}
import com.softwaremill.sttp.file.{File => sttpFile}

trait sttpExtensions {

  def asFile(file: DomFile, overwrite: Boolean = false): ResponseAs[DomFile, Nothing] = {
    ResponseAsFile(sttpFile.fromDomFile(file), overwrite).map(_.toDomFile)
  }

  /**
    * Content type will be set to `application/octet-stream`, can be overridden
    * later using the `contentType` method.
    *
    * File name will be set to the name of the file.
    */
  def multipartFile(name: String, file: DomFile): Multipart =
    multipart(name, sttpFile.fromDomFile(file))

}
