SUMMARY = "Base class for DAC Images with SDL support"

inherit  dac-image-wayland

DISTRO_FEATURES_append = " wayland"

IMAGE_INSTALL_append = " libsdl2"

