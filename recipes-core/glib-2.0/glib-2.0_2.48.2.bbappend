# | ../../glib-2.48.2/gio/gdbusauth.c: In function '_g_dbus_auth_run_server':
# | ../../glib-2.48.2/gio/gdbusauth.c:1298:11: error: '%s' directive argument is null [-Werror=format-overflow=]
# |  1298 |           debug_print ("SERVER: WaitingForBegin, read '%s'", line);

TARGET_CFLAGS += " -Wno-error=format-overflow"

