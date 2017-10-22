call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openpage
echo Cannot open Tomcat
goto fail

:openpage
start "" http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open Google Chrom
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished