SUMMARY = "Base class for including app metadata for given image"

do_install_append() {
  if [ -f ${S}/appmetadata.json ]; then
    install -p -m 0755 -D ${S}/appmetadata.json     ${D}/appmetadata.json
  else
    echo "Repository doesn't contain appmetadata.json file which should contain info about your application. It is required by BundleGen. Please add it to your repository so it can be included into the image."
    exit 1
  fi
}

FILES_${PN} += "/appmetadata.json"
