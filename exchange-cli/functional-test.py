import os.path
import subprocess

cmd = "exchange"

def test_cli_help():
    """
    GIVEN the command is available on PATH
    WHEN the command is run with the help flag
    THEN the CLI should print help info
    AND the command should exit normally
    """
    cli = subprocess.run([cmd, "--help"], capture_output=True)
    assert "Convert from one currency to another" in cli.stdout.decode()
    assert cli.returncode == 0

def test_cli_convert_simple():
    """
    GIVEN the command is available on PATH
    AND the USD currency is defined
    WHEN the command is run with `exchange -i usd -o usd 3.5`
    THEN the CLI should convert from USD to USD
    AND the command should exit normally
    """
    cli = subprocess.run([cmd, "-i", "usd", "-o", "usd", "3.5"], capture_output=True)
    assert "3.5 USD -> 3.5 USD\n" == cli.stdout.decode()
    assert cli.returncode == 0

def test_cli_convert_different():
    """
    GIVEN the command is available on PATH
    AND the USD currency is defined
    AND the JPY currency is defined
    WHEN the command is run with `exchange -i usd -o jpy 3.5`
    THEN the CLI should convert between two different currencies
    AND the command should exit normally
    """
    cli = subprocess.run([cmd, "-i", "usd", "-o", "jpy", "3.5"], capture_output=True)
    assert "3.5 USD -> 364.6 JPY\n" == cli.stdout.decode()
    assert cli.returncode == 0

def test_cli_missing_flag():
    """
    GIVEN the command is available on PATH
    WHEN the command is run with a missing flag
    THEN the CLI should exit with non-zero return
    AND print the missing arg
    """
    cli = subprocess.run([cmd, "-i usd"], capture_output=True)
    assert cli.returncode > 0
    assert "Missing required flag" in cli.stderr.decode()

def test_cli_missing_all_flags():
    """
    GIVEN the command is available on PATH
    WHEN the command is run with no arguments
    THEN the CLI should exit with non-zero return
    AND print missing args
    """
    cli = subprocess.run(cmd, capture_output=True)
    assert cli.returncode > 0
    assert "Missing required flags" in cli.stderr.decode()
