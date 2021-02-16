SUMMARY = "Example SDL test application"

LICENSE = "CLOSED"

DEPENDS = "virtual/libgles2 virtual/libsdl2"

SRC_DAC_EXAMPLES = "home/maricnh/workspace/dac-examples-src"

S = "${WORKDIR}/${SRC_DAC_EXAMPLES}/sdl-test/"

SRC_URI = " \
    file:///${SRC_DAC_EXAMPLES}"

inherit autotools pkgconfig

TEST_NAME         = "sdl-test"

TARGET_CC_ARCH    += "${LDFLAGS}"

do_compile () {
  cd ${S}
  ${CXX} ${TARGET_CXXFLAGS}              -o ${TEST_NAME}       main.cpp    $(pkg-config --cflags --libs       glesv2 sdl2)
}

do_install() {
  install -p -m 0755 -D ${S}/${TEST_NAME}         ${D}${bindir}/${TEST_NAME}
}

FILES_${PN} += "${bindir}/*"

