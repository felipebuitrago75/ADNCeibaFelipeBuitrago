// spec.js
describe('Prueba pantalla principal', function() {
    it('should have a title', function() {
      browser.get('http://localhost:4200/');
  
      expect(browser.getTitle()).toEqual('Front');
    });
  });

  describe('Prueba pantalla principal', function() {
    it('should have a title', function() {
      browser.get('http://localhost:4200/crear-persona');
  
      expect(browser.getTitle()).toEqual('Front');
    });
  });