SUMMARY = "Example SDL test application"

LICENSE = "CLOSED"

DEPENDS = "virtual/libgles2 virtual/libsdl2"

S = "${WORKDIR}/git/sdl-test"

SRC_URI = " \
    git://github.com/MarcinHajkowski/dac-examples-src.git;protocol=http;branch=master;rev=11c4ad3649e830886babbd0d6e0836e8a3c36e76 \
"


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

