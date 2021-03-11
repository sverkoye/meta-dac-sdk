SUMMARY = "Example DAC SDL 2D demo game application"

LICENSE = "CLOSED"

DEPENDS = " libsdl2-image libsdl2-ttf virtual/libsdl2 ttf-abyssinica"

S = "${WORKDIR}/git/sdl-game-test"

SRC_URI = " \
    git://github.com/MarcinHajkowski/dac-examples-src.git;protocol=http;branch=master;rev=1dc41089df1371050b6973a1ecee7d5b700c7c23"


inherit autotools pkgconfig

TEST_NAME         = "sdl-game-test"

TARGET_CC_ARCH    += "${LDFLAGS}"

do_compile () {
  cd ${S}
  ${CXX} ${TARGET_CXXFLAGS}              -o ${TEST_NAME}       *.cpp    $(pkg-config --cflags --libs       sdl2 SDL2_image SDL2_ttf)
}

do_install() {
  install -p -m 0755 -D ${S}/${TEST_NAME}              ${D}${bindir}/${TEST_NAME}
  install -p -m 0755 -D ${S}/resources/player.png      ${D}${datadir}/resources/player.png
  install -p -m 0755 -D ${S}/resources/mapTile.png     ${D}${datadir}/resources/mapTile.png
  install -p -m 0755 -D ${S}/resources/1.level         ${D}${datadir}/resources/1.level
}

FILES_${PN} += "${bindir}/*"
FILES_${PN} += "${datadir}/*"

