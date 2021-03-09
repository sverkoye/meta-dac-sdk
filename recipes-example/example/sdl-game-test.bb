SUMMARY = "Example DAC SDL 2D demo game application"

LICENSE = "CLOSED"

DEPENDS = " libsdl2-image libsdl2-ttf virtual/libsdl2"

S = "${WORKDIR}/git/sdl-game-test"

SRC_URI = " \
    git://github.com/MarcinHajkowski/dac-examples-src.git;protocol=http;branch=master;rev=89472d8c0dafe413c7362b4daf9101e37c5de3af"



inherit autotools pkgconfig

TEST_NAME         = "sdl-game-test"

TARGET_CC_ARCH    += "${LDFLAGS}"

do_compile () {
  cd ${S}
  ${CXX} ${TARGET_CXXFLAGS}              -o ${TEST_NAME}       *.cpp    $(pkg-config --cflags --libs       sdl2 SDL2_image SDL2_ttf)
}

do_install() {
  install -p -m 0755 -D ${S}/${TEST_NAME}              ${D}${bindir}/${TEST_NAME}
  install -p -m 0755 -D ${S}/resources/player.png      ${D}${bindir}/resources/player.png
  install -p -m 0755 -D ${S}/resources/mapTile.png     ${D}${bindir}/resources/mapTile.png
  install -p -m 0755 -D ${S}/resources/1.level         ${D}${bindir}/resources/1.level
  install -p -m 0755 -D ${S}/resources/SEASRN.ttf      ${D}${bindir}/resources/SEASRN.ttf
}

FILES_${PN} += "${bindir}/*"

