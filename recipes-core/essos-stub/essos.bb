LICENSE = "CLOSED"
SUMMARY = "Create essos library containing stub implementation for essos-app interface"

DEPENDS = "wayland virtual/egl"

inherit autotools pkgconfig

SRC_URI += " \
    file://essos.cpp \
    file://essos-app.h \
    file://configure.ac \
    file://Makefile.am"

S = "${WORKDIR}"
