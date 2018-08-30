set /a i=1

:sd
copy unit1_a.xml unit%i%_a.xml
copy unit1_b.xml unit%i%_b.xml
copy unit1_c.xml unit%i%_c.xml
if %i% ==105 (
exit
)
set /a i=i+1
goto sd