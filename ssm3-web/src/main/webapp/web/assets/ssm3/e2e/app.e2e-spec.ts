import { Ssm3Page } from './app.po';

describe('ssm3 App', () => {
  let page: Ssm3Page;

  beforeEach(() => {
    page = new Ssm3Page();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
