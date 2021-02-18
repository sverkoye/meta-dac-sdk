SUMMARY = "GStreamer sample application"
DESCRIPTION = "Simple GStreamer test application" 

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=31ebd4cb723386d5569981c4a007b091"

DEPENDS = "gstreamer1.0"

inherit pkgconfig

SRC_URI = " \
    git://github.com/ZbyszekK/player.git;protocol=http;branch=master;rev=2c03e67b528ef75835acd484c53ab2eac066ec38 \
"

S = "${WORKDIR}/git/"
TARGET_CC_ARCH += "${LDFLAGS}"

OUTPUT_NAME = "gst-play-test"

do_compile () {
    cd ${S}
    ${CC} -o ${OUTPUT_NAME} player.c $(pkg-config --cflags --libs gstreamer-1.0)
}

do_install () {
    install -p -m 0755 -D ${S}/${OUTPUT_NAME} ${D}${bindir}/${OUTPUT_NAME}
}

FILES_${PN} += "${bindir}/*"
