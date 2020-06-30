/*
 * This is a fragment of the Dashiell Standard Package
 * Provided under the MIT License
 * @author Dashiell
 */

package codes.dashiell.standard;

public enum SimpleResult {
  SUCCESS(false),
  FAILURE(true)
  ;
  private final boolean bad;

  SimpleResult(boolean isBad){
    this.bad = isBad;
  }

  public boolean isBad(){
    return this.bad;
  }
}
