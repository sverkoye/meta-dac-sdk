# substitutte westeros dependency with essos stub library from SDK
DEPENDS_remove = "wpeframework-clientlibraries"
DEPENDS_remove = "westeros"
DEPENDS_append = "essos"

CMF_GIT_PROTOCOL ?= "https"
CMF_GIT_ROOT ?= "git://code.rdkcentral.com/r"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://RemoveWPEFramework.patch"
SRC_URI += "file://Disable-cast-function-type-warning.patch"

INSANE_SKIP_${PN} += "ldflags"
