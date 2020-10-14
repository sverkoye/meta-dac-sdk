LICENSE = "CLOSED"

DEPENDS = "essos virtual/egl"

SRC_URI = " \
    git://github.com/stagingrdkm/dac-examples-src.git;protocol=http;branch=master;rev=927725b156d7be6ceb98301422a2cb5650ae8cd6 \
"

inherit autotools pkgconfig

S = "${WORKDIR}/git/essos-test/"

